package fdit.alteration.core.incident;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.write;
import static fdit.alteration.core.incident.IncidentJsonHelper.*;
import static fdit.alteration.core.incident.Parameter.MODE_OFFSET;
import static fdit.alteration.core.incident.Parameter.MODE_SIMPLE;
import static java.nio.charset.StandardCharsets.UTF_8;
import static fdit.testTools.PredicateAssert.assertThat;

public class IncidentDeserializerJsonTest {

    @Test
    public void deserialize_json_test_1() throws IOException {
        final File incidentFile = File.createTempFile("incidentjson", ".json");
        write("{" +

                        "\"sensors\": {\n" +
                            "\"sensor\":\n" +
                                "[{\n" +
                                    "\"sensorType\": \"SBS\",\n" +
                                    "\"sID\": \"ALL\",\n" +
                                    "\"record\": \"\",\n" +
                                    "\"filter\": \"\",\n" +
                                    "\"action\": [\n" +
                                            "{\n" +
                                                "\"alterationType\": \"ALTERATION\",\n" +
                                                "\"scope\": {\n" +
                                            "\"type\": \"timeWindow\",\n" +
                                                    "\"lowerBound\": \"10\",\n" +
                                                    "\"upperBound\": \"1050\"\n" +
                                                "},\n" +
                                            "\"parameters\": {\n" +
                                                    "\"target\": \n" +
                                                        "{\n" +
                                                            "\"identifier\": \"hexIdent\",\n" +
                                                                "\"value\": \"ALL\"\n" +
                                                        "}\n" +
                                                    ",\n" +
                                                    "\"parameter\": [\n" +
                                                        "{\n" +
                                                            "\"mode\": \"simple\",\n" +
                                                                "\"key\": \"ICAO\",\n" +
                                                                "\"value\": \"39AC47\"\n" +
                                                        "},\n" +
                                                        "{\n" +
                                                            "\"mode\": \"simple\",\n" +
                                                                "\"key\": \"CALLSIGN\",\n" +
                                                                "\"value\": \"SAMU25\"\n" +
                                                        "}\n" +
                                                    "]\n" +
                                                "}\n" +
                                            "}\n" +
                                    "]\n" +
                                "}]\n" +
                            "\n" +
                        "}\n" +

                "}\n", incidentFile, UTF_8);

        final IncidentDeserializerJson deserializer = new IncidentDeserializerJson(incidentFile);
        System.out.println(deserializer.deserialize().getSensors().size());
        assertThat(deserializer.deserialize(),
                anIncident(withSensors(
                        aSensor("SBS", "ALL", "", "",
                                withActions(
                                        anAction("ALTERATION",
                                                withScopeTimeWindow(10, 1050),
                                                withParameters(
                                                        onTargetHexIdent("ALL"),
                                                        aParameter(MODE_SIMPLE, "ICAO", "39AC47"),
                                                        aParameter(MODE_SIMPLE, "CALLSIGN", "SAMU25")))
                                        )))));

    }
}