## POST - Crear un nuevo respaldo (/api/respaldos)

{
  "rutaArchivo": "/ruta/nuevo_respaldo.json",
  "tipo": "completo",
  "sistema": "sistemaA"
}

## GET - Obtener todos los respaldos (/api/respaldos)
## http://localhost:8080/api/respaldos

## GET - Obtener un respaldo por ID (/api/respaldos/{id})
## http://localhost:8080/api/respaldos/3

## DELETE - Eliminar un respaldo (/api/respaldos/{id})
## ejemplo: http://localhost:8080/api/respaldos/3

## La ruta para la petición PUT 
## http://localhost:8080/api/respaldos/{id}

{
  "idRespaldo": 3,
  "fechaHora": "2025-05-15T22:15:00.123Z",
  "rutaArchivo": "/otra/ruta/respaldo_actualizado.bak",
  "tipo": "completo",
  "sistema": "sistemaA"
}