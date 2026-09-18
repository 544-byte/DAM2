''' Ejercicio 1
nombre = "pepe"
nota = "10"
modulo = "ipe"
mensaje = f'El alumno {nombre} sacó un {nota} en el módulo de {modulo}'
print(f"a) {mensaje}" )
print(f"b) {mensaje.upper()}")
mensaje = mensaje.replace("módulo","asignatura")
print(f"c) {mensaje}")
'''

''' Ejercicio 2
print("Ingrese su año de nacimiento: ")
birthyear = input()
print(f"Su edad es {2026 - int(birthyear)}")
'''

''' Ejercicio 3

'''

puntuaciones = [45,82,90,31,68,100,55,74]

def recorrerLista(lista):
    for i in lista:
        print(i)

print("a) ")
recorrerLista(puntuaciones)

insuficiente = list(filter(lambda x : x < 50, puntuaciones))
notable = list(filter(lambda x : 50 <= x <= 79, puntuaciones))
sobresaliente = list(filter(lambda x : x >= 80, puntuaciones))

print("b)\nInsuficiente:")
recorrerLista(insuficiente)
print("\nNotable:")
recorrerLista(notable)
print("\nSobresaliente:")
recorrerLista(sobresaliente)

print(f"\nMedia: {sum(puntuaciones)/len(puntuaciones)}")