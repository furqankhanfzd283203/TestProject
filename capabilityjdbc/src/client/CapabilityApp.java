package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Capability;
import entity.Ko;
import exception.ApplicationException;
import exception.ServiceException;
import exception.service.CapabilityIdNotFoundException;
import service.CapabilityService;
import service.KoService;
import service.serviceImpl.CapabilityServiceImpl;
import service.serviceImpl.KoServiceImpl;

public class CapabilityApp {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ApplicationException {
		CapabilityService capabilityService = new CapabilityServiceImpl();
		KoService koService = new KoServiceImpl();

		int choice = 0;
		do {
			System.out.println("1:Add capabilty");
			System.out.println("2:add ko under the capability");
			System.out.println("3:Display all KO details under the given capability name");
			System.out.println("4:Display all KO details under the given capability status");
			System.out.println("5:Display sorted KO details based on Ko's name");
			System.out.println("6:Exit");
			System.out.println("enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				Capability[] capability = addCapability();
				Capability[] capabilty = capabilityService.insertCapabilityIntoDB(capability);
				break;
			case 2:
				System.out.println("enter capability id");

				int id = sc.nextInt();
				Capability capability1 = capabilityService.checkCapability(id);
				if (capability1 == null) {
					throw new CapabilityIdNotFoundException("Given capability id is not present");

				} else {
					Ko[] ko = addKo(capability1);
					Ko[] ko1 = koService.insertKoIntoDB(ko);
				}
				break;
			case 3:

				System.out.println("enter capability name");
				String name = sc.next();

				List<Ko> koByName = koService.getAllKoByCapabilityNameFromDB(name);
				displayKo(koByName);
				break;
			case 4:

				System.out.println("enter capability status");
				String status = sc.next();

				List<Ko> koByStatus = koService.getAllKoByCapabilityStatusFromDB(status);

				displayKo(koByStatus);
				break;
			case 5:

				koService.getSortedKoByNameFromDB();
				// displayKo1(sortedKo);

				break;
			case 6:
				System.out.println("you are Exit");
				break;
			default:
				System.out.println("you enter invalid choice");
			}
		} while (choice != 6);
	}

	private static Capability[] addCapability() {
		System.out.println("How many capability you want to add");
		int input = sc.nextInt();
		Capability[] capability = new Capability[input];
		for (int i = 0; i < capability.length; i++) {
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter status");
			String status = sc.next();

			capability[i] = new Capability(id, name, status);
		}
		return capability;
	}

	private static Ko[] addKo(Capability capability) {
		System.out.println("How many ko you want to add");
		int input = sc.nextInt();
		Ko[] ko = new Ko[input];
		for (int i = 0; i < ko.length; i++) {
			System.out.println("enter id");
			int id = sc.nextInt();
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter koType");
			String koType = sc.next();
			System.out.println("enter description");
			String description = sc.next();

			ko[i] = new Ko(id, name, koType, description, capability);
		}

		return ko;
	}

	private static void displayKo(List<Ko> kos) {
		for (Ko ko : kos) {
			System.out.println(ko + " ");
		}
	}

}
