CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `view_title` AS
    SELECT 
        tconst,
        end_year,
        genres,
        is_adult,
        original_title,
        primary_title,
        runtime_minutes,
        start_year,
        title_type
    FROM
        titles;