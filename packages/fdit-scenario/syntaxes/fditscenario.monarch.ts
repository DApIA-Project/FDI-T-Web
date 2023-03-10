// Monarch syntax highlighting for the fditscenario language.
export default {
    keywords: [
        'ALERT','ALTITUDE','ALT_DURATION','CALLSIGN','EAST_WEST_VELOCITY','EMERGENCY','GROUNDSPEED','ICAO','LATITUDE','LONGITUDE','NORTH_SOUTH_VELOCITY','NUMBER','REC_DURATION','REC_NBR_AIRCRAFT','SPI','SQUAWK','TRACK','all_planes','alter','alter_speed','and','assert','at','create','cut','delay','filter','for','from','from_recording','groovy_file','hide','let','plane','replay','rotate','satisfying','saturate','seconds','triggered_by','until','with_altitude','with_angle','with_delay','with_frequency','with_values','with_waypoints'
    ],
    operators: [
        '*','*=','++=','+=',',','--=','-=','<<','=','>>'
    ],
    symbols:  /\(|\)|\*|\*=|\+\+=|\+=|,|--=|-=|<<|=|>>|\[|\]|\{|\}/,

    tokenizer: {
        initial: [
            { include: '@whitespace' },
            { regex: /@symbols/, action: { cases: { '@operators': {"token":"operator"}, '@default': {"token":""} }} },
        ],
        whitespace: [
            { regex: /\s+/, action: {"token":"white"} },
        ],
        comment: [
        ],
    }
};
