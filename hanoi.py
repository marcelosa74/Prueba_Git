# Comentario para prueba de GITHUB
# 16-06-2021
# Este codigo ha sido generado por el modulo psexport 20180802-w32 de PSeInt.
# Es posible que el codigo generado no sea completamente correcto. Si encuentra
# errores por favor reportelos en el foro (http://pseint.sourceforge.net).


# El objetivo del juego es mover los discos de la torre 1 a la 3 en la
# menor cantidad de movimientos posible. No se puede colocar un disco de 
# un tamanio sobre otro mas chico
# Hay una matriz que representa las torres, cada columna contiene
# nros que representan los tamanios de los discos en esas torres (solo
# interesan los valores hasta la cantidad de discos de esa torre).
# Cuantos discos tiene cada torre lo dice el vector cant_discos. 
import os

if __name__ == '__main__':
	os.system ("cls") 
	torres = [[int() for ind0 in range(10)] for ind1 in range(3)]
	cant_discos = [int() for ind0 in range(3)]
	# pedir y validar cuantos discos colocar en la primer torre
	print("Ingrese el nro de discos (1-8):")
	discos = int(input())
	while discos<1 or discos>8:
		print("El numero de discos debe ser mayor a 0 y menor a 5:")
		discos = int(input())
	# inicializar los datos
	cant_discos[0] = discos
	cant_discos[1] = 0
	cant_discos[2] = 0
	for i in range(1,discos+1):
		torres[0][i-1] = discos-i+1
	# jugar!
	cant_movs = 0
	# mientras no esten todos los discos en la tercer torre, el juego sigue
	while cant_discos[2]!=discos:
		print("") # no hay forma directa de borrar la pantalla con Python estandar
		# dibujar las tres torres
		for i in range(1,4):
			print("Torre ",i)
			if cant_discos[i-1]==0:
				print("")
			else:
				# recorrer los discos de la torre, de arriba hacia abajo
				for j in range(cant_discos[i-1],0,-1):
					# dibujar cada disco
					if torres[i-1][j-1]==1:
						print("                   **")
					elif torres[i-1][j-1]==2:
						print("                 ******")
					elif torres[i-1][j-1]==3:
						print("               **********")
					elif torres[i-1][j-1]==4:
						print("             **************")
					elif torres[i-1][j-1]==5:
						print("           ******************")
					elif torres[i-1][j-1]==6:
						print("         **********************")
					elif torres[i-1][j-1]==7:
						print("       **************************")
					elif torres[i-1][j-1]==8:
						print("     ******************************")
			print("   ----------------------------------")
			print("")
		# solicitar movimiento
		print("Mover desde la torre: ")
		t1 = int(input())
		print("hacia la torre: ")
		t2 = int(input())
		# controlar que el nro de torre sea valido
		if t1<1 or t1>3 or t2<1 or t2>3:
			print("Movimiento invalido")
			input() 
		else:
			# controlar que la torre 1 tengo al menos un disco
			if cant_discos[t1-1]==0:
				print("Movimiento invalido")
				input() 
				
			else:
				# obtener tamanio del disco que se quiere mover
				disco_a_mover = torres[t1-1][cant_discos[t1-1]-1]
				puede_mover = True
				# controlar que la torre dos no tenga discos o tenga solo discos mas grandes
				if cant_discos[t2-1]!=0:
					if torres[t2-1][cant_discos[t2-1]-1]<disco_a_mover:
						puede_mover = False
				# si paso todos los controles, mover
				if puede_mover:
					cant_movs = cant_movs+1
					cant_discos[t2-1] = cant_discos[t2-1]+1
					torres[t2-1][cant_discos[t2-1]-1] = disco_a_mover
					cant_discos[t1-1] = cant_discos[t1-1]-1
				else:
					print("Movimiento invalido")
					input() 
	# mostrar resultado
	print("") # no hay forma directa de borrar la pantalla con Python estandar
	print("Juego finalizado en ",cant_movs," movimientos!")

