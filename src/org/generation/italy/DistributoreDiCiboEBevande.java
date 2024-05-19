package org.generation.italy;

//import 
import java.util.Scanner;
import java.util.ArrayList;

public class DistributoreDiCiboEBevande {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Scanner sc = new Scanner(System.in);
		// variabili, array e liste
		double soldiUtente = 0, bilancioMacchinetta = 100, newPrice;
		ArrayList<Integer> quantitaProd = new ArrayList<Integer>();
		ArrayList<String> codiceProd = new ArrayList<String>();
		ArrayList<Double> prezziProd = new ArrayList<Double>();
		ArrayList<String> nomiProd = new ArrayList<String>();
		String[] codiceAtt = { "1", "2", "3", "4", "5", "6" };
		String[] nomiAtt = { "Modifica Prezzo", "Stampa Bilancio", "Quantità Prodotti", "Eroga Prodotto",
				"Aggiungi Prodotto", "Rimuovi Prodotto" };
		double resto = 0;
		String codiceGestore = "12345", codiceAttIns, codiceModPrezz, codiceModQuant;
		int i, prodRim, newQuant;

		// inserimento prod default liste
		quantitaProd.add(3);
		quantitaProd.add(7);
		quantitaProd.add(10);
		quantitaProd.add(2);
		codiceProd.add("111");
		codiceProd.add("222");
		codiceProd.add("333");
		codiceProd.add("444");
		prezziProd.add(2.0);
		prezziProd.add(2.50);
		prezziProd.add(1.50);
		prezziProd.add(3.50);
		nomiProd.add("Patatine");
		nomiProd.add("Coca Cola");
		nomiProd.add("Caramelle");
		nomiProd.add("Mars");
		// inizio ciclo do while per loop
		do {
			String codiceInserito;
			boolean indiceProd = false;
			// stmpa array nomi
			for (i = 0; i < codiceProd.size(); i++)
				System.out.println("i prodotti nella macchientta sono: " + nomiProd.get(i) + " e il relativo codice è "
						+ codiceProd.get(i));
			// richiesta codice
			System.out.print("Selezionare codice prodotto: ");
			codiceInserito = sc.nextLine();
			// codizione per accedere al lato gestore

			// LATO GESTORE
			if (codiceInserito.equalsIgnoreCase(codiceGestore)) {
				System.out.println("Benvenuto Gestore");
				System.out.println("inserisci il codice per ciò che vuoi fare:");
				codiceAttIns = sc.nextLine();
				// modifica prezzo
				if (codiceAttIns.equalsIgnoreCase(codiceAtt[0])) {
					System.out.println("avendo inserito il codice " + codiceAtt[0] + " hai selezionato " + nomiAtt[0]);
					System.out.println("inserisci il codice del prodotto alla quale vuoi modificare il prezzo:");
					codiceModPrezz = sc.nextLine();
					for (i = 0; i < codiceProd.size(); i++) {
						if (codiceProd.get(i).equalsIgnoreCase(codiceModPrezz)) {
							System.out.println("il prodotto scelto è: " + nomiProd.get(i)
									+ " e il suo prezzo attuale è " + prezziProd.get(i));
							// inserisci nuovo prezzo
							System.out.println("Inserisci il nuovo prezzo del prodotto:");
							newPrice = sc.nextInt();
							prezziProd.set(i, newPrice);
							System.out.println("il prezzo del prodotto è stato cambiata, il prezzo attuale è: "
									+ prezziProd.get(i));
							break;
						} else {
							System.out.println("codice prodotto non trovato");
							break;
						}
					}
					// stampa bilancio
				} else if (codiceAttIns.equalsIgnoreCase(codiceAtt[1])) {
					System.out.println("il bilancio attuale nella macchinetta è " + bilancioMacchinetta);
					// modifica quantità prod
				} else if (codiceAttIns.equalsIgnoreCase(codiceAtt[2])) {
					System.out.println("avendo inserito il codice " + codiceAtt[2] + " hai selezionato " + nomiAtt[2]);
					System.out.println("inserisci il codice del prodotto alla quale vuoi modificare la quantità:");
					codiceModQuant = sc.nextLine();
					for (i = 0; i < codiceProd.size(); i++) {
						if (codiceProd.get(i).equalsIgnoreCase(codiceModQuant)) {
							System.out.println("il prodotto scelto è: " + nomiProd.get(i)
									+ " e la sua quantità attuale è " + quantitaProd.get(i));
							System.out.println("Inserisci la nuova quantità del prodotto:");
							newQuant = sc.nextInt();
							sc.nextLine();
							quantitaProd.set(i, newQuant);
							System.out.println("La quantità del prodotto è stata cambiata, la quantità attuale è: "
									+ quantitaProd.get(i));
							break;
						} else {
							System.out.println("codice prodotto non trovato");
							break;
						}
					}
					// eroga prodotto gratis
				} else if (codiceAttIns.equalsIgnoreCase(codiceAtt[3])) {
					System.out.println("avendo inserito il codice " + codiceAtt[3] + " hai selezionato " + nomiAtt[3]);
					System.out.print("Selezionare codice prodotto: ");
					codiceInserito = sc.nextLine();
					for (i = 0; i < codiceProd.size(); i++) {
						// verifica all'interno dell arrayList
						if (codiceProd.get(i).equalsIgnoreCase(codiceInserito)) {
							indiceProd = true;
							// verifica quantità
							if (quantitaProd.get(i) >= 1) {
								// stampa prodotto
								System.out.println("erogazione prodotto in corso");
								// riduzione quantità arrayList
								prodRim = quantitaProd.get(i);
								quantitaProd.set(i, prodRim - 1);
							} else {
								System.out.println("Quantità non disponibile.");
							}
						}
					}
					if (!indiceProd) {
						System.out.println("Prodotto non trovato.");
					}
					indiceProd = false;
					// aggiungi prodotto
				} else if (codiceAttIns.equalsIgnoreCase(codiceAtt[4])) {
					System.out.println("avendo inserito il codice " + codiceAtt[4] + " hai selezionato " + nomiAtt[4]);
					System.out.println("Inserisci il nome del nuovo prodotto");
					nomiProd.add(sc.nextLine());
					System.out.println("Inserisci il codice del nuovo prodotto");
					codiceProd.add(sc.nextLine());
					System.out.println("Inserisci il prezzo del nuovo prodotto");
					prezziProd.add(sc.nextDouble());
					sc.nextLine();
					System.out.println("Inserisci la quantità del nuovo prodotto");
					quantitaProd.add(sc.nextInt());
					sc.nextLine();
					System.out.println("Il prodotto è stato aggiunto");
					// elimina prodotto
				} else if (codiceAttIns.equalsIgnoreCase(codiceAtt[5])) {
					System.out.println("avendo inserito il codice " + codiceAtt[5] + " hai selezionato " + nomiAtt[5]);
					System.out.println("inserisci il codice del prodotto che vuoi rimuovere:");
					String codiceRemoveProd = sc.nextLine();
					for (i = 0; i < codiceProd.size(); i++) {
						// verifica codice all'interno dell arrayList
						if (codiceProd.get(i).equalsIgnoreCase(codiceRemoveProd)) {
							System.out.println(
									"il prodotto scelto è: " + nomiProd.get(i) + " desideri rimuoverlo davvero?");
							String rispRemove = sc.nextLine();
							if (rispRemove.equalsIgnoreCase("si") || rispRemove.equalsIgnoreCase("sì")) {
								nomiProd.remove(i);
								prezziProd.remove(i);
								quantitaProd.remove(i);
								codiceProd.remove(i);
								System.out.println("Il prodotto è stato rimosso");
								break;
							}
						} else {
							System.out.println("codice prodotto non trovato");
							break;
						}
					}
				} else {
					System.out.println("Codice attività non trovato");
				}
			} else {

				// *INIZIO LATO UTENTE*

				// ciclo for per ricerca elemento
				for (i = 0; i < codiceProd.size(); i++) {
					// verifica all'interno dell array
					if (codiceProd.get(i).equalsIgnoreCase(codiceInserito)) {
						indiceProd = true;
						// verifica quantità
						if (quantitaProd.get(i) >= 1) {
							// stampa prezzo e richiesta monete
							System.out.println("Il prezzo del prodotto è " + prezziProd.get(i) + " €.");
							System.out.println("inserire le monete una alla volta");
							// inizio ciclo do while per inserimento altre monete
							do {
								// aumento soldi inseriti
								soldiUtente = soldiUtente + sc.nextDouble();
								sc.nextLine();
								// verifica di impporto sufficente
								if (soldiUtente >= prezziProd.get(i)) {
									// riduzione quantità array
									prodRim = quantitaProd.get(i);
									quantitaProd.set(i, prodRim - 1);
									// calcolo resto
									resto = soldiUtente - prezziProd.get(i);
									// stampa prodotto
									System.out.println("erogazione prodotto in corso");
									// verifica presenza di resto e stampa
									if (resto > 0) {
										System.out.println("il resto è " + resto + " €. verrà erogato a breve");
									}
									// aumento bilancio e azzeramento variabili
									bilancioMacchinetta = (bilancioMacchinetta + prezziProd.get(i));
									resto = 0;
								} else {
									System.out.println("L'importo rimanente è " + (prezziProd.get(i) - soldiUtente)
											+ " euro, inserire un'altra moneta:");
								}
								// fine ciclo do while inserimento monete
							} while (soldiUtente < prezziProd.get(i));
							soldiUtente = 0;
							// quantità prodotto non disponibile
						} else {
							System.out.println("Quantità non disponibile.");
						}
					}
				}
				// verifica codice non presente nella macchinetta
				if (!indiceProd) {
					System.out.println("Prodotto non trovato.");
				}
				System.out.println("arrivederci");
				// fine ciclo do while per richiedere nuovamente tutto
			}
		} while (true);

		// *FINE LATO UTENTE*

	}// fine main
}// fine progetto
