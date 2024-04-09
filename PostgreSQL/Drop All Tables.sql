DO
$$
DECLARE
    table_rec RECORD;
BEGIN
    FOR table_rec IN (SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' AND table_type = 'BASE TABLE') LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(table_rec.table_name) || ' CASCADE';
    END LOOP;
END
$$;