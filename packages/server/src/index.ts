"use strict";
import express from 'express';
import cors from 'cors';
import * as fs from 'fs';
import {exec} from 'child_process';
import setRoutes from './appRoute';
import {parseAndGenerate} from '@smartesting/fdit-scenario/dist/web'

const app = express();

app.use(cors());
app.use(express.json());
app.use('/', setRoutes());



export const generateAndDisplay = (async (scenario : string, nom_fichier : string) : Promise<{} | undefined> => {
    console.info('generating & running current code...');
    // parse & generate commands for drawing an image
    // execute custom LSP command, and receive the response
    const dslCmds = await parseAndGenerate(scenario, "",nom_fichier,"");
    fs.writeFileSync("public/test.json",JSON.stringify(dslCmds));

    executeAlterationJar(nom_fichier);

    return Promise.resolve(dslCmds);

    //updateDslCanvas(dslCmds);
});

function executeAlterationJar(nom_fichier : string) : void {
  exec("java -jar ..\\alteration\\out\\artifacts\\alteration_atc_jar\\alteration-atc.jar .\\public\\test.json " + nom_fichier, (error, stdout, stderr) => {
    if (error) {
        console.error(`L'exécution a échoué : ${error}`);
        return;
    }
    console.log(`Sortie : ${stdout}`);
});
}



app.listen(3001, () => console.log('Server started on port 3001'));