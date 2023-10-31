package controller;

import br.edu.fatec.zl.Lista;

public class OrdenaController {

	Lista<Integer>[] hashTable = new Lista[100];

	public OrdenaController() {
		int tamanho = hashTable.length;
		for (int i = 0; i < tamanho; i++) {
			hashTable[i] = new Lista<Integer>();
		}
	}

	private int hash(int n) {
		int posi��o = (int) (100*(((((Math.sqrt(7) - 1) / 2) * n) % 1)));
		return posi��o;
	}

	public void calculaPosi��o(int[] vet) {
		int size = vet.length;
		int hash = 0;
		for (int i = 0; i < size; i++) {
			hash = hash(vet[i]);
			Lista<Integer> linha = hashTable[hash];
			if (linha.isEmpty()) {
				try {
					linha.addFirst(vet[i]);
				} catch (Exception e) {
					System.err.println(e);
				}
			} else {
				try {
					linha.addLast(vet[i]);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
		listaPosi��o();
	}

	public void listaPosi��o() {
		for (int i = 0; i < 100; i++) {
			Lista<Integer> linha = hashTable[i];

			if (!linha.isEmpty()) {
				System.out.println("Existem " + linha.size() + " elementos na lista " + i + ". \nEles s�o:");
				int c = linha.size();
				for (int in = 0; in < c; in++) {
					try {
						System.out.println("#" + linha.get(in));
					} catch (Exception e) {
						System.err.println(e);
					}
				}
			} else {
				System.out.println("N�o existem elementos na lista " + i);
			}
		}
	}

}
