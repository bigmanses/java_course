import javax.sound.midi.Soundbank;

public class Lesson3_2 {
    public static final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public int hashCode(){
            return (int) (11*1000000*re*im);
        }

        @Override
        public boolean equals(Object obj){

            if(this == obj)
                return true;
            if(obj == null)
                return false;
            if(!(obj instanceof ComplexNumber)) {
                return false;
            }

            ComplexNumber help = (ComplexNumber) obj;
            return Double.compare(this.re, help.getRe()) == 0 &&
                    Double.compare(this.im, help.getIm()) == 0;
        }
    }
    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn2 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn3 = new ComplexNumber(3.23124,1435.23);
        System.out.println("equals cn1 & cn2 true // " + cn1.equals(cn2));
        System.out.println("equals cn2 & cn1 true // " + cn2.equals(cn1));
        System.out.println("equals cn2 & cn3 false // " + cn2.equals(cn3));
        System.out.println("equals cn3 & cn1 false // " + cn3.equals(cn1));
        System.out.println("hash cn1 & cn2 true // " + (cn1.hashCode() == cn2.hashCode()));
        System.out.println("hash cn2 & cn1 true // " + (cn2.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn1 false // " + (cn3.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn2 false // " + (cn3.hashCode() == cn2.hashCode()));

    }
}
