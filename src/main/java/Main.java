import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

// Você foi contratado para desenvolver uma aplicação que monta o mapa astral dos funcionários de uma empresa.
// Com base na data, hora e local de nascimento, escreva métodos que printe na tela:

public class Main {

    public static void main(String[] args) {

        LocalDateTime localDateTimeLucas = LocalDateTime.of(1993, Month.DECEMBER, 16, 12, 35);
        LocalDateTime localDateTimeTomas = LocalDateTime.of(1999, Month.AUGUST, 30, 12, 30);
        LocalDateTime localDateTimeArtur = LocalDateTime.of(1987, Month.MARCH, 25, 19, 30);
        LocalDateTime localDateTimeDavi = LocalDateTime.of(1992, Month.OCTOBER, 29, 8, 30);

        mapaAstral(localDateTimeArtur, "Fortaleza");

    }

    // Constroi o mapa astral da pessoa
    private static void mapaAstral(LocalDateTime dataHoraNascimento, String localNascimento) {

        System.out.println("#################################");

        imprimeIdade(dataHoraNascimento);

        imprimeNascimentoFormatado(dataHoraNascimento);

        imprimeZoneOffset(dataHoraNascimento, localNascimento);

        ehAnoBissexto(dataHoraNascimento);

        System.out.println("Signo: " + imprimeSigno(dataHoraNascimento.toLocalDate()));

        if (dataHoraNascimento.getYear() > 1976) {
            System.out.println("Ascendente: " + ascendente(imprimeSigno(dataHoraNascimento.toLocalDate()), dataHoraNascimento.toLocalTime().minusHours(2)));
        } else if (dataHoraNascimento.getYear() > 1946)  {
            System.out.println("Ascendente: " + ascendente(imprimeSigno(dataHoraNascimento.toLocalDate()), dataHoraNascimento.toLocalTime().minusHours(1)));
        } else {
            System.out.println("Ascendente: " + ascendente(imprimeSigno(dataHoraNascimento.toLocalDate()), dataHoraNascimento.toLocalTime()));
        }

        System.out.println("Signo Lunar: " + signoLunar(dataHoraNascimento.toLocalTime(), localNascimento));

        System.out.println("#################################");

    }

    // A idade da pessoa
    private static void imprimeIdade(LocalDateTime dataHoraNascimento) {

        Period idade = Period.between(dataHoraNascimento.toLocalDate(), LocalDate.now());
        System.out.println("Idade: " + idade.getYears());

    }

    // Data de nascimento formatada (dd/MM/yyyy HH:mm)
    private static void imprimeNascimentoFormatado(LocalDateTime dataHoraNascimento) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
        String dataFormatada = formatter.format(dataHoraNascimento);
        System.out.println(dataFormatada);

    }

    // ZoneOffset do local de nascimento (ex: +03:00, -01:00)
    private static void imprimeZoneOffset(LocalDateTime dataHoraNascimento, String localNascimento) {

        Set<String> zones = ZoneId.getAvailableZoneIds();
        ZoneId zoneId = ZoneId.of("Europe/London");

        // System.out.println(zones);

        for (String s : zones) {
            if (s.contains(localNascimento)) {
                zoneId = ZoneId.of(s);
                // System.out.println(zoneId.getId());
            }
        }

        ZoneOffset currentOffsetForMyZone = zoneId.getRules().getOffset(dataHoraNascimento);
        System.out.println("TZ: " + currentOffsetForMyZone);

    }

    // Se o ano de nascimento é bissexto
    private static void ehAnoBissexto(LocalDateTime dataHoraNascimento) {

        System.out.println("Ano bissexto: " + dataHoraNascimento.toLocalDate().isLeapYear());

    }

   // O signo da pessoa (implementar pelo menos 2 signos)
    private static String imprimeSigno(LocalDate dataNascimento) {

        MonthDay monthDayNascimento = MonthDay.of(dataNascimento.getMonth(), dataNascimento.getDayOfMonth());

        MonthDay ariesStartDate = MonthDay.of(3, 21);
        MonthDay ariesEndDate = MonthDay.of(4, 20);

        MonthDay touroStartDate = MonthDay.of(4, 21);
        MonthDay touroEndDate = MonthDay.of(5, 20);

        MonthDay gemeosStartDate = MonthDay.of(5, 21);
        MonthDay gemeosEndDate = MonthDay.of(6, 20);

        MonthDay cancerStartDate = MonthDay.of(6, 21);
        MonthDay cancereEndDate = MonthDay.of(7, 22);

        MonthDay leaoStartDate = MonthDay.of(7, 23);
        MonthDay leaoEndDate = MonthDay.of(8, 22);

        MonthDay virgemStartDate = MonthDay.of(8, 23);
        MonthDay virgemEndDate = MonthDay.of(9, 22);

        MonthDay libraStartDate = MonthDay.of(9, 23);
        MonthDay libraEndDate = MonthDay.of(10, 22);

        MonthDay escorpiaoStartDate = MonthDay.of(10, 23);
        MonthDay escorpiaoEndDate = MonthDay.of(11, 21);

        MonthDay sagitarioStartDate = MonthDay.of(11, 22);
        MonthDay sagitarioEndDate = MonthDay.of(12, 21);

        // Caso não seja um dos outros 11 signos, será Capricórnio
        // MonthDay capricornioStartDate = MonthDay.of(12, 22);
        // MonthDay capricornioEndDate = MonthDay.of(1, 20);

        MonthDay aquarioStartDate = MonthDay.of(1, 21);
        MonthDay aquarioEndDate = MonthDay.of(2, 19);

        MonthDay peixesStartDate = MonthDay.of(2, 19);
        MonthDay peixesEndDate = MonthDay.of(3, 20);


        if (isWithinRange(monthDayNascimento, ariesStartDate, ariesEndDate)) {
            return "Aries";
        } else if (isWithinRange(monthDayNascimento, touroStartDate, touroEndDate)) {
            return "Touro";
        } else if (isWithinRange(monthDayNascimento, gemeosStartDate, gemeosEndDate)) {
            return "Gêmeos";
        } else if (isWithinRange(monthDayNascimento, cancerStartDate, cancereEndDate)) {
            return "Câncer";
        } else if (isWithinRange(monthDayNascimento, leaoStartDate, leaoEndDate)) {
            return "Leão";
        } else if (isWithinRange(monthDayNascimento, virgemStartDate, virgemEndDate)) {
            return "Virgem";
        } else if (isWithinRange(monthDayNascimento, libraStartDate, libraEndDate)) {
            return "Libra";
        } else if (isWithinRange(monthDayNascimento, escorpiaoStartDate, escorpiaoEndDate)) {
            return "Escorpião";
        } else if (isWithinRange(monthDayNascimento, sagitarioStartDate, sagitarioEndDate)) {
            return "Sargitário";
        } else if (isWithinRange(monthDayNascimento, aquarioStartDate, aquarioEndDate)) {
            return "Aquário";
        } else if (isWithinRange(monthDayNascimento, peixesStartDate, peixesEndDate)) {
            return "Peixes";
        } else {
            return "Capricórnio";
        }

    }

    // O ascedente (implementar pelo menos para um signo).
    private static String ascendente(String signo, LocalTime horarioDeNascimento) {

        if("Aries".equalsIgnoreCase(signo)) {
            if(isWithinRange(horarioDeNascimento, LocalTime.of(6,31), LocalTime.of(8,30))){
                return "Aries";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(8,31), LocalTime.of(10,30))){
                return "Touro";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(10,31), LocalTime.of(12,30))){
                return "Gêmeos";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(12,31), LocalTime.of(14,30))){
                return "Câncer";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(14,31), LocalTime.of(16,30))){
                return "Leão";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(16,31), LocalTime.of(18,30))){
                return "Virgem";
            }  else if(isWithinRange(horarioDeNascimento, LocalTime.of(18,31), LocalTime.of(20,30))){
                return "Libra";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(20,31), LocalTime.of(22,30))){
                return "Escorpião";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(0,31), LocalTime.of(2,30))){
                return "Capricórnio";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(2,31), LocalTime.of(4,30))){
                return "Aquário";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(4,31), LocalTime.of(6,30))){
                return "Peixes";
            } else {
                return "Sagitário";
            }
        } else if("Touro".equalsIgnoreCase(signo)) {
            if(isWithinRange(horarioDeNascimento, LocalTime.of(6,31), LocalTime.of(8,30))){
                return "Touro";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(8,31), LocalTime.of(10,30))){
                return "Gêmeos";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(10,31), LocalTime.of(12,30))){
                return "Câncer";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(12,31), LocalTime.of(14,30))){
                return "Leão";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(14,31), LocalTime.of(16,30))){
                return "Virgem";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(16,31), LocalTime.of(18,30))){
                return "Libra";
            }  else if(isWithinRange(horarioDeNascimento, LocalTime.of(18,31), LocalTime.of(20,30))){
                return "Escorpião";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(20,31), LocalTime.of(22,30))){
                return "Sagitário";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(0,31), LocalTime.of(2,30))){
                return "Aquário";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(2,31), LocalTime.of(4,30))){
                return "Peixes";
            } else if(isWithinRange(horarioDeNascimento, LocalTime.of(4,31), LocalTime.of(6,30))){
                return "Aries";
            } else {
                return "Capricórnio";
            }
        }

        return "Implementado para apenas para o signos de Aries e Touro.";

    }

    // Signo Lunar
    private static String signoLunar(LocalTime time, String localNascimento) {

        Set<String> zones = ZoneId.getAvailableZoneIds();

        for (String s : zones) {
            if (s.contains(localNascimento)) {
                ZoneId zoneId = ZoneId.of(s);
                // System.out.println(zoneId);

                if (zoneId.toString().equals("America/Recife") && time.isAfter(LocalTime.NOON)) {
                    return "Casimiro";
                }

                if (zoneId.toString().equals("America/Cuiaba") && time.isBefore(LocalTime.NOON)) {
                    return "Odin";
                }

                if (zoneId.toString().equals("America/Sao_Paulo")) {
                    return "Gandalf";
                }
            }
        }

        return  "Dinossauro";

    }

    private static boolean isWithinRange(MonthDay dataNascimento, MonthDay startDate, MonthDay endDate) {

        return !(dataNascimento.isBefore(startDate) || dataNascimento.isAfter(endDate));

    }

    private static boolean isWithinRange(LocalTime horarioDeNascimento, LocalTime startTime, LocalTime endTime) {

        return !(horarioDeNascimento.isBefore(startTime) || horarioDeNascimento.isAfter(endTime));

    }

}