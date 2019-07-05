package laktest;

/*Создать систему запросов
 «Болезнь → Регистрация →
  Терапевт → Специализированный врач (5)».
  Специализированный врач -
  это хирург, окулист, аллерголог,
  дерматолог, кардиолог.
  Клиента интересует лечение болезни,
  с корой он обратился в поликлинику,
  болезнь имеет ряд симптомов:
  депигментация кожи,
  головокружение, красные глаза,
  слезоточивость, сухие глаза, вялость,
  головная боль, жар, кровотечение из носа,
  повышенная температура,
  боль в груди, кашель, одышка,
  хрипы в груди и пр..
  Пользователь использует регистратуру
  для нахождения терапевта, затем терапевт,
  если это не по его направлению, назначает посетить
  oдного из специализированных врачей.
  Использовать паттерн «Цепочка обязанностей».
  Данные о болезнях,
  которые лечат врачи берутся из внешних входных
  файлов «therapist», «surgeon», «oculist» ,
  «allergist», «dermatologist» и «cardiologist»
  соответственно.*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello guys");
        ChainLink registry = new Registry();
        registry.addNext(new Doc("Therapist"));
        registry.getFirst().addNext(new Doc("Cardiologist"));
        registry.getFirst().addNext(new Doc("Oculist"));


        String arg = "Pain";
        try {
            arg=args[0];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("OK");
        }
        System.out.println(registry.Recognize(arg));

    }
}

