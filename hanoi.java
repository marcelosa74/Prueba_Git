//Comentario prueba 1
/* Este codigo ha sido generado por el modulo psexport 20180802-w32 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net). */

// En java, el nombre de un archivo fuente debe coincidir con el nombre de la clase que contiene,
// por lo que este archivo debería llamarse "HANOI.java."

import java.io.*;

public class hanoi {

	// El objetivo del juego es mover los discos de la torre 1 a la 3 en la
	// menor cantidad de movimientos posible. No se puede colocar un disco de 
	// un tamanio sobre otro mas chico
	// Hay una matriz que representa las torres, cada columna contiene
	// nros que representan los tamanios de los discos en esas torres (solo
	// interesan los valores hasta la cantidad de discos de esa torre).
	// Cuantos discos tiene cada torre lo dice el vector cant_discos. 
	public static void main(String args[]) throws IOException {
		BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
		int cant_discos[];
		double cant_movs;
		double discos;
		int disco_a_mover;
		int i;
		int j;
		boolean puede_mover;
		int t1;
		int t2;
		int torres[][];
		torres = new int[3][10];
		cant_discos = new double[3];
		// pedir y validar cuantos discos colocar en la primer torre
		System.out.println("Ingrese el nro de discos (1-8):");
		discos = Double.parseDouble(bufEntrada.readLine());
		while (discos<1 || discos>8) {
			System.out.println("El numero de discos debe ser mayor a 0 y menor a 5:");
			discos = Double.parseDouble(bufEntrada.readLine());
		}
		// inicializar los datos
		cant_discos[0] = discos;
		cant_discos[1] = 0;
		cant_discos[2] = 0;
		for (i=1;i<=discos;i++) {
			torres[0][i-1] = discos-i+1;
		}
		// jugar!
		cant_movs = 0;
		// mientras no esten todos los discos en la tercer torre, el juego sigue
		while (cant_discos[2]!=discos) {
			System.out.println(""); // no hay forma directa de borrar la consola en Java
			// dibujar las tres torres
			for (i=1;i<=3;i++) {
				System.out.println("Torre "+i);
				if (cant_discos[i-1]==0) {
					System.out.println("");
				} else {
					// recorrer los discos de la torre, de arriba hacia abajo
					for (j=cant_discos[i-1];j>=1;j--) {
						// dibujar cada disco
						switch (torres[i-1][j-1]) {
						case 1:
							System.out.println("                   XX");
							break;
						case 2:
							System.out.println("                 XXXXXX");
							break;
						case 3:
							System.out.println("               XXXXXXXXXX");
							break;
						case 4:
							System.out.println("             XXXXXXXXXXXXXX");
							break;
						case 5:
							System.out.println("           XXXXXXXXXXXXXXXXXX");
							break;
						case 6:
							System.out.println("         XXXXXXXXXXXXXXXXXXXXXX");
							break;
						case 7:
							System.out.println("       XXXXXXXXXXXXXXXXXXXXXXXXXX");
							break;
						case 8:
							System.out.println("     XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							break;
						}
					}
				}
				System.out.println("   ----------------------------------");
				System.out.println("");
			}
			// solicitar movimiento
			System.out.println("Mover desde la torre: ");
			t1 = Integer.parseInt(bufEntrada.readLine());
			System.out.println("hacia la torre: ");
			t2 = Integer.parseInt(bufEntrada.readLine());
			// controlar que el nro de torre sea valido
			if (t1<1 || t1>3 || t2<1 || t2>3) {
				System.out.println("Movimiento invalido");
				System.in.read(); // a diferencia del pseudocódigo, espera un Enter, no cualquier tecla
			} else {
				// controlar que la torre 1 tengo al menos un disco
				if (cant_discos[t1-1]==0) {
					System.out.println("Movimiento invalido");
					System.in.read(); // a diferencia del pseudocódigo, espera un Enter, no cualquier tecla
				} else {
					// obtener tamanio del disco que se quiere mover
					disco_a_mover = torres[t1-1][cant_discos[t1-1]-1];
					puede_mover = true;
					// controlar que la torre dos no tenga discos o tenga solo discos mas grandes
					if (cant_discos[t2-1]!=0) {
						if (torres[t2-1][cant_discos[t2-1]-1]<disco_a_mover) {
							puede_mover = false;
						}
					}
					// si paso todos los controles, mover
					if (puede_mover) {
						cant_movs = cant_movs+1;
						cant_discos[t2-1] = cant_discos[t2-1]+1;
						torres[t2-1][cant_discos[t2-1]-1] = disco_a_mover;
						cant_discos[t1-1] = cant_discos[t1-1]-1;
					} else {
						System.out.println("Movimiento invalido");
						System.in.read(); // a diferencia del pseudocódigo, espera un Enter, no cualquier tecla
					}
				}
			}
		}
		// mostrar resultado
		System.out.println(""); // no hay forma directa de borrar la consola en Java
		System.out.println("Juego finalizado en "+cant_movs+" movimientos!");
	}


}

