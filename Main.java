import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<LogMessage> logs = new ArrayList<>();
        
        
        String[] dates = {"11 сентябрь 2026", "12 сентябрь 2026", "14 сентябрь 2026", "15 сентябрь 2026"};
        String[] types = {"INFO", "ERROR"};
        String[] messages = {"Сервер запущен", "Код завершился с ошибкой", "Сервер взломали", "Пользователь подключился"};

        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            String randomDate = dates [random.nextInt(dates.length)];
            String randomTypes = types [random.nextInt(types.length)];
            String randomText = messages [random.nextInt(messages.length)];
            

            logs.add(new LogMessage(randomDate, randomTypes, randomText));

        }

        System.out.println("=== сгенерированные логи ===");

        for (LogMessage log : logs){
            System.out.println(log.toLogString());
        }
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nВыберите действие:");
        System.out.println("1 - Вывести логи за конкретный месяц");
        System.out.println("2 - Вывести логи конкретного типа (INFO/ERROR)");
        System.out.println("3 - Сохранить логи в файлы по датам");
        System.out.print("Введите цифру: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // чистим буфер
        
        if (choice == 1) {
            System.out.println("введите месяц (сентябрь): ");
            String month = scanner.nextLine();

            System.out.println("=== логи зща месяц: " + month + " ===");
            
            for(LogMessage log : logs) {
                if (log.getDate().contains(month)) {
        
                    System.out.println(log.toLogString());
                }


            }
        }
        else if (choice == 2){
            System.out.println("введите тип лога(ERROR/INFO): ");
            String type = scanner.nextLine();

            System.out.println("=== логи типа:" + type + " ===");

            for(LogMessage log : logs ){
                if (log.getType().equals(type)){
                    System.out.println(log.toLogString());
                }
            }
        }

        else if (choice == 3) {
            System.out.println("Созранение...");

            for ( String currentDate : dates){
               
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(currentDate + ".txt"))) {// это сделал вс код чтоб небыло предупреждения Convert to try-with-resources
                     
                    
                     for(LogMessage log : logs){
                        if (log.getDate().equals(currentDate)){
                            writer.write(log.toLogString());
                            writer.newLine();

                        }
                     }
                        
                        System.out.println("Файл успешно создан: " + currentDate + ".txt");
                    
                    }catch(IOException e){
                        System.out.println("ошибка при попытке записи");
                        e.printStackTrace();
                    }
                
                
              
            }
        }
        scanner.close();
    }
}

