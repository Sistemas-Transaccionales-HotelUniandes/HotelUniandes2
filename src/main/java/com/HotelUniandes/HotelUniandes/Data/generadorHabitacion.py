import json
import random

class HabitacionGenerator:
    def __init__(self):
        self.current_id = 1

    def generar_habitacion(self):
        tipo_habitacion_ids = list(range(1, 11))

        habitacion = {
            "_id": self.current_id,
            "tipoHabitacionId": random.choice(tipo_habitacion_ids),
            "_class": "com.HotelUniandes.HotelUniandes.model.Habitacion"
        }

        self.current_id += 1

        return habitacion

# Crear una instancia de la clase HabitacionGenerator
generator = HabitacionGenerator()

# Generar 200 habitaciones
habitaciones = [generator.generar_habitacion() for _ in range(200)]

# Guardar las habitaciones en un archivo JSON
with open('/src/main/java/com/HotelUniandes/HotelUniandes/Data/habitaciones.json', 'w') as file:
    json.dump(habitaciones, file, indent=2)

print("Se han generado y guardado 200 habitaciones en el archivo 'habitaciones.json'.")
