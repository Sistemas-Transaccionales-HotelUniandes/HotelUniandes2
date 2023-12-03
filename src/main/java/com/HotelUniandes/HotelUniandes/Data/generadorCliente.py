import json
import random

class ClienteGenerator:
    def __init__(self):
        self.current_id = 1
        self.current_reserva_id = 1

    def generar_nombre_aleatorio(self):
        nombres = ["Sergio", "María", "Carlos", "Ana", "Pedro", "Laura", "Diego"]
        return random.choice(nombres)

    def generar_email_aleatorio(self):
        dominios = ["gmail.com", "yahoo.com", "hotmail.com", "outlook.com"]
        nombre = self.generar_nombre_aleatorio().lower()
        dominio = random.choice(dominios)
        return f"{nombre}_{random.randint(100, 999)}@{dominio}"

    def generar_documento_aleatorio(self):
        letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        numeros = "0123456789"
        return f"{random.choice(letras)}{random.choice(letras)}{random.choice(numeros)}{random.choice(numeros)}{random.choice(letras)}{random.choice(letras)}{random.choice(numeros)}{random.choice(numeros)}{random.choice(numeros)}{random.choice(numeros)}"

    def generar_cliente(self):
        tipos_documento = ["Pasaporte", "CC", "TI"]
        estados = ["Llegado", "No llegado"]

        cliente = {
            "_id": self.current_id,
            "nombre": self.generar_nombre_aleatorio(),
            "email": self.generar_email_aleatorio(),
            "tipodocumento": random.choice(tipos_documento),
            "documento": self.generar_documento_aleatorio(),
            "reservaId": self.current_reserva_id,
            "estado": random.choice(estados),
            "_class": "com.HotelUniandes.HotelUniandes.model.Cliente"
        }

        self.current_id += 1
        self.current_reserva_id += 1

        return cliente

# Crear una instancia de la clase ClienteGenerator
generator = ClienteGenerator()

# Generar 200 clientes
clientes = [generator.generar_cliente() for _ in range(200)]

# Guardar los clientes en un archivo JSON
with open('/src/main/java/com/HotelUniandes/HotelUniandes/Data/clientes.json', 'w') as file:
    json.dump(clientes, file, indent=2)

print("Se han generado y guardado 200 clientes en el archivo 'clientes.json'.")
