package TopInterviewQuestions;

/**
 * Created by NISHANT on 3/30/18.
 */
public class nTon {
//    private static nTon objDoubleton1;
//    private static nTon objDoubleton2;
//    private nTon(){
//    }
//
//    // Factory Method
//    public  static nTon getInstance(){
//        if(objDoubleton1 == null){
//            objDoubleton1 = new nTon();
//            return objDoubleton1;
//        }
//        else if(objDoubleton2 == null){
//            objDoubleton2 = new nTon();
//            return objDoubleton2;
//        }
//        else{
//            if(Math.random() < 0.5)
//                return objDoubleton1;
//            else
//                return objDoubleton2;
//        }
//    }

    //    Below is the snapshot of the double ton pattern. getInstance() method will return the instance as a round robin fashion.
//    private static nTon[] doubleTon;
//    private static int index;
//
//    public static nTon getInstance(){
//        if(doubleTon == null){
//            synchronized (nTon.class) {
//                doubleTon= new nTon[2];
//                doubleTon[0] = new nTon();
//                doubleTon[1] = new nTon();
//            }
//        }
//        return doubleTon[index++%2];
//    }

    private static nTon[] array = new nTon[2];
    private static nTon firstInstance = null;
    private static nTon secInstance = null;
// private constructor

    public static nTon[] getInstance() {
        if (firstInstance == null) {
            firstInstance = new nTon();
            array[0] = firstInstance;
        } else {
            if (secInstance == null) {
                secInstance = new nTon();
                array[1] = secInstance;
            }
        }
        return array;
    }
}
