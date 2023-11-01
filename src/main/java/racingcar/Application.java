package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Car> cars = new ArrayList<Car>();
        List<String> names = askName();
        for (int i = 0; i < 3; i++) {
            cars.get(i).setName(names.get(i));
        }

        int n = askCount();
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < n; i++) {
            play(cars);
        }

        printResult(cars);
    }
    public static void play(List<Car> cars){
        for (int i = 0; i < 3; i++) {
            cars.get(i).tryToMove();
        }

        // 결과출력
        for (int i = 0; i < 3; i++) {
            System.out.print(cars.get(i).getName()+" : ");
            for (int j = 0; j < cars.get(i).getMoveCount(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static List<String> askName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");

        String[] names = readLine().split(",");
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ret.add(names[i]);
        }
        return ret;
    }
    public static int askCount(){
        System.out.println("시도할 회수는 몇회인가요?\n");
        return Integer.parseInt(readLine());
    }
    public static void printResult(List<Car> cars){
        int maxValue = Integer.MIN_VALUE;
        List<String> winers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int moveCount = cars.get(i).getMoveCount();
            if (moveCount > maxValue){
                maxValue = moveCount;
                winers.clear();
                winers.add(cars.get(i).getName());
            }
            else if (moveCount == maxValue){
                winers.add(cars.get(i).getName());
            }
        }

        System.out.print("최종 우승자 : "+String.join(", ",winers));
    }

}
