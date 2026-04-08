package LIkeLion;
public class week3Array {
    static class Book{
    //객체가 가지는 속성 정의
    String title;
    int price;

    //객체가 새로 만들어질 떄 처음값을 초기화해줌
    Book(String title, int price) {
        /* 매게변수(Title)와 필드(this.title)의 이름이 같을 떄,
        이건 이거라고 명확히 구분해주는 역할 */
        this.title = title;
        this.price = price;
    }

    //매서드 --> 객체가 할 수 있는 동작 정의
    void displayInfo() {
        System.out.println("도서명: " + title + " | 가격: " + price + "원");
        }


    //매서드 오버로딩
    /* 이름이 displayInfo로 같으나 괄호 한의 String user(매게변수)가 다르면 자바가
        자바가 알아서 구분하게 쓰게 해줌 */
    void displayInfo(String user) {
        System.out.println("[" + user + "님의 조회 결과] 도서명: " + title);
        }
    }

    public static void main(String[] args) {

        //객체 배열
        /* Book 이라는 여러개 담을 수 있는 서람장을 [] 개 만듦ㅣ */
        Book[] library = new Book[3];

        //예외 처리 : try --> 에러날 수 있으니까 주의 깊게 실행하기
        try {

            // 객체 생성(인스턴스화) 및 인덱스 접근
            /* new 키워드 이용해서 새로운 객체를 만들고 0부터 2까지 총 3개에 나누어 저장 */
            library[0] = new Book("사자의 정석", 30000);
            library[1] = new Book("멋사 입문", 22000);
            library[2] = new Book("멋대 가이드", 28000);

            System.out.println("=== 전체 도서 목록 ==");

            // for문 배열의 length 속성
            /* 배열의 크기를 library length[3] 만큼 반복하면서 배열 하나씩 열어서
             배열 정보(displayInfo)를 출력하게 함 */
            for (int i = 0; i < library.length; i++) {
                library[i].displayInfo();
            }

            System.out.println("\n=== 특정 사용자 맞춤 출력 (오버로딩) ===");

            /* 오버로딩 된 매서드 호출 displauInfo(매게변수)를 넣으면, 자동으로 두 번쨰 displayInfo()를
            찾아서 실행함 */
            library[0].displayInfo("멋사");

            System.out.println("\n=== 예외 발생 테스트 ===\n");
            /* 의도적인 Runtime Error 유발함
            서랍은 0,1,2 까짐나 있는데 그 이상을 열려고 해서 터지는 지점, 여기서 숫자를 0으로 나누거나 catch(ArrayIndexOutOF~)
             에 잡히지 않는 오류 코드를 넣으면 catch (Exception e) {System.err.println("경고: 알 수 없는 오류가 발생했습니다.");} 에 잡힘  */
            System.out.println(library[5].title);


        /* 다중 catch 블록으로 구체적 예외 처리
        위에서 터진 에러라 객체배열 초과 에러라면 여기서 catch 해서 처리함.(프로그램 강제 종료 방지) */
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("경고 : 배열의 크기를 벗어난 접근입니다. (Index Error)");

        // 예외처리 --> 위에서 잡지 못한 에러가 나면 여기서 잡음
        } catch (Exception e) {
            System.err.println("경고: 알 수 없는 오류가 발생했습니다.");

        // 예외처리 finally. 에러나 나든 안 나든 반드시 프로그램이 끝나기 전에 실행해야하는 정리 작업
        } finally {
            System.out.println("[시스템] 리소스 정리 후 프로그램을 종료합니다.");
            }
        }
    }
