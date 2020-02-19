# smoor-builder-server
The back end component of a character builder based on the system of Shadowmoor LARP


EXAMPLE REQUESTS:

POST NEW USER - http://localhost:8080/api/user

{
    "username": "yaBoiHP",
    "firstName": "Howard",
    "lastName":"Lovecraft",
    "email":"hplovin@shoggoth.net",
    "password": "rylyeh"
}

POST NEW CHARACTER - http://localhost:8080/api/character

{
    "username": "yaBoiHP",
    "build_total": 127,
    "character_name": "Randolf Carter",
    "race_name":"Surface Elf",
    "class_name": "Templar",
    "background": "Randolf Carter of Rhode Island was an ancient dreamer without the bonds of humanity to hold him",
    "description": "An ancient dreamer of arcane portent",
    "image": "silver_key_.gif"
}

POST NEW ACTION INVENTORY - http://localhost:8080/api/character/action

{
    "character_name": "Randolf Carter",
    "action_name":"Critical Slay",
    "combat_action_total" : "2"
}