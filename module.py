import time
import random
import requests

def read_temperature_sensor():
    return round(random.uniform(20.0, 30.0), 2)

server_url = "http://example.com/api/temperature"

while True:
    temperature = read_temperature_sensor()
    data = {'temperature': temperature}
    
    try:
        response = requests.post(server_url, json=data)
        if response.status_code == 200:
            print(f"Dados enviados com sucesso: {data}")
        else:
            print(f"Erro ao enviar dados: {response.status_code}")
    except Exception as e:
        print(f"Erro na comunicação com o servidor: {e}")
    
    time.sleep(60)
