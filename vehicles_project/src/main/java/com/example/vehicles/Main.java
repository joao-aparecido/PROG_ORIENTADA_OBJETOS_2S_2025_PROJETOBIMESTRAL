package com.example.vehicles;

import com.example.vehicles.db.DatabaseConnection;
import com.example.vehicles.model.*;
import com.example.vehicles.service.VehicleService;

import java.util.*;

public class Main {
    private static final VehicleService service = new VehicleService();

    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1 - Cadastrar veículo");
            System.out.println("2 - Consultar veículos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            String opt = sc.nextLine();

            switch (opt) {
                case "1": cadastrar(sc); break;
                case "2": consultar(sc); break;
                case "0": running = false; break;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrar(Scanner sc) {
        System.out.print("Tipo (1-Carro / 2-Moto): ");
        String tipo = sc.nextLine();
        System.out.print("Marca: ");
        String brand = sc.nextLine();
        System.out.print("Modelo: ");
        String model = sc.nextLine();
        System.out.print("Ano: ");
        int year = Integer.parseInt(sc.nextLine());

        if ("1".equals(tipo)) {
            System.out.print("Número de portas: ");
            int doors = Integer.parseInt(sc.nextLine());
            Car c = new Car(null, brand, model, year, doors);
            service.addVehicle(c);
            System.out.println("Carro cadastrado com id=" + c.getId());
        } else {
            System.out.print("Cilindrada (cc): ");
            double engine = Double.parseDouble(sc.nextLine());
            Motorcycle m = new Motorcycle(null, brand, model, year, engine);
            service.addVehicle(m);
            System.out.println("Moto cadastrada com id=" + m.getId());
        }
    }

    private static void consultar(Scanner sc) {
        System.out.println("1 - Listar todos");
        System.out.println("2 - Consultar por id");
        String op = sc.nextLine();

        if ("1".equals(op)) {
            List<Vehicle> all = service.listAll();
            all.forEach(System.out::println);
        } else {
            System.out.print("Id: ");
            int id = Integer.parseInt(sc.nextLine());
            Vehicle v = service.getById(id);
            System.out.println(v == null ? "Não encontrado" : v);
        }
    }
}
