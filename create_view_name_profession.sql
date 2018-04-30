CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `view_name_profession` AS
    SELECT 
        `nm`.`primary_name` AS `primary_name`,
        `nm`.`birth_year` AS `birth_year`,
        `nm`.`death_year` AS `death_year`,
        `nm`.`nconst` AS `nconst`,
        `pr`.`profession` AS `profession`
    FROM
        ((`name` `nm`
        JOIN `name_to_profession` `ntp`)
        JOIN `profession` `pr`)
    WHERE
        ((`nm`.`nconst` = `ntp`.`nconst`)
            AND (`pr`.`id` = `ntp`.`id_profession`))