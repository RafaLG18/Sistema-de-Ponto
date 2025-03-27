-- Inserindo 100 funcionários na tabela 'funcionario'
DO $$
DECLARE
    i INT;
BEGIN
    FOR i IN 1..100 LOOP
        INSERT INTO "funcionario" ("nome", "cargo")
        VALUES ('Funcionário ' || i, 
                CASE 
                    WHEN i % 5 = 1 THEN 'Analista de Sistemas'
                    WHEN i % 5 = 2 THEN 'Gerente de Projetos'
                    WHEN i % 5 = 3 THEN 'Desenvolvedor'
                    WHEN i % 5 = 4 THEN 'Designer'
                    ELSE 'Administrador de Banco de Dados'
                END);
    END LOOP;
END $$;

-- Inserindo 200 registros na tabela 'registro'
DO $$
DECLARE
    i INT;
    id_funcionario INT;
    data_base DATE := '2025-03-01';
    hora_base TIME := '08:00:00';
BEGIN
    FOR i IN 1..200 LOOP
        -- Seleciona um funcionário aleatório entre os IDs existentes
        SELECT "id" INTO id_funcionario 
        FROM "funcionario" 
        OFFSET FLOOR(RANDOM() * 100) LIMIT 1;

        -- Insere o registro
        INSERT INTO "registro" ("id_funcionario", "data_registro", "hora_chegada")
        VALUES (
            id_funcionario, 
            TO_CHAR(data_base + (i % 30), 'YYYY-MM-DD'), 
            TO_CHAR(hora_base + (i % 120) * INTERVAL '1 minute', 'HH24:MI')
        );
    END LOOP;
END $$;
