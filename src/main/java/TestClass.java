import com.google.gson.*;
import model.Organisation;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class TestClass {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader("src\\main\\resources\\organization.json")) {
            Type listType = new TypeToken<List<Organisation>>() {}.getType();
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) -> LocalDate.parse(json.getAsJsonPrimitive().getAsString())).create();
            List<Organisation> list = gson.fromJson(reader, listType);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate currentDate = LocalDate.now();

            list.forEach(
                    organisation ->
                    System.out.println(organisation.getShortName() + " - Дата основания: " + organisation.getEgrulDate().format(formatter)));
            System.out.println();

            list.stream().
                    flatMap(organisation -> organisation.getSecurities().stream()).
                    filter(security -> security.getDateTo().isBefore(currentDate)).
                    forEach(s -> System.out.println("Код:"+ s.getCode() + ", дата истечения: " + s.getDateTo() + ", название: " + s.getFullName()));
                        //TODO: Вывести название ценной бумаги или компании?
            System.out.println();

            long count = list.stream().
                    flatMap(organisation -> organisation.getSecurities().stream().
                            filter(security -> security.getDateTo().isBefore(currentDate))).
                    count();
            System.out.println("Общее количество просроченных бумаг: " + count);


            String text = "06.03.2009";
            //String text = "06.03,05";
            //String text = "06/03/2005";
            //String text = "06/03/2015";

            //String text  = "EUR";
            //String text  = "USD";
            //String text  = "RUB";
            System.out.println("\nВвод пользователя: " + text);

            if (text.matches("^[A-Z]{3}$")) {
                list.stream().
                        flatMap(organisation -> organisation.getSecurities().stream()).
                        filter(security -> security.getCurrency().getCode().equals(text)).
                        forEach(security -> System.out.println("ID бумаги: " + security.getId() + ", код бумаги: " + security.getCode()));
            } else if (text.matches("^\\d{2}.\\d{2}.\\d{2,4}$")){
                String format = null;
                if (text.matches("\\d{2}/\\d{2}/\\d{2}")){
                    format = "dd/MM/yy";
                } else if (text.matches("\\d{2}/\\d{2}/\\d{4}")){
                    format = "dd/MM/yyyy";
                } else if (text.matches("\\d{2}\\.\\d{2}\\.\\d{4}")){
                    format = "dd.MM.yyyy";
                } else if (text.matches("\\d{2}\\.\\d{2},\\d{2}")){
                    format = "dd.MM,yy";
                }
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(format);
                LocalDate date = LocalDate.parse(text,formatter1);
                list.stream().
                        filter(organisation -> organisation.getEgrulDate().isAfter(date)).
                        forEach(s-> System.out.println(s.getFullName() +", дата создания: "+ s.getEgrulDate()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
