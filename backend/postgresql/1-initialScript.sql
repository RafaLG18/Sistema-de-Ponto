CREATE TABLE "funcionario"(
    "id" SERIAL NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "cargo" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "funcionario" ADD PRIMARY KEY("id");
CREATE TABLE "registro"(
    "id" SERIAL NOT NULL,
    "id_funcionario" INTEGER NOT NULL,
    "data_registro" VARCHAR(255) NOT NULL,
    "hora_chegada" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "registro" ADD PRIMARY KEY("id");
ALTER TABLE
    "registro" ADD CONSTRAINT "registro_id_funcionario_foreign" FOREIGN KEY("id_funcionario") REFERENCES "funcionario"("id");