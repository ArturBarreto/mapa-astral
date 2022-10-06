import service.Service;
import type.Tuple;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

// Você foi contratado para desenvolver uma aplicação que monta o mapa astral dos funcionários de uma empresa.
// Com base na data, hora e local de nascimento, escreva métodos que printe na tela:

public class Main {

    public static void main(String[] args) {

        List<Tuple<String, LocalDateTime, String>> pessoas = new ArrayList<>();

        pessoas.add(Tuple.create("Artur", LocalDateTime.of(1987, Month.MARCH, 25, 19, 30), "Fortaleza"));
        pessoas.add(Tuple.create("Lucas", LocalDateTime.of(1999, Month.AUGUST, 30, 12, 30), "São Paulo"));
        pessoas.add(Tuple.create("Ana", LocalDateTime.of(1993, Month.DECEMBER, 16, 12, 35), "Recife"));
        pessoas.add(Tuple.create("Pedro", LocalDateTime.of(1992, Month.OCTOBER, 29, 8, 30), "Brasília"));

        pessoas.stream().forEach(Service::mapaAstral);

    }

}
