public class Polynomial {
    double [] coeff;

    //constructor 
    public Polynomial() { 
        this.coeff = new double[] {0};
    }
    //second constructor
    public Polynomial(double[]coeff) { 
        this.coeff = new double[coeff.length];
        for(int i = 0; i < coeff.length; i++) { 
            this.coeff[i] = coeff[i];
        }
    }

    //function add 
    public Polynomial add(Polynomial p2) { 
        //get min length poly
        int minLength = 0;
        int maxLength = 0;
        double []maxP;
        if(this.coeff.length > p2.coeff.length) { 
            minLength = p2.coeff.length;
            maxLength = this.coeff.length;
            maxP = this.coeff;
        }
        else { 
            minLength = this.coeff.length; 
            maxLength = p2.coeff.length; 
            maxP = p2.coeff;
        }
        double [] res = new double[maxLength]; //for overflow
        //length of poly <= maxLength + 1
        for(int i = 0; i < minLength; i++) { 
            res[i] = p2.coeff[i] + this.coeff[i];
        }
        //for rest of poly 
        for(int i = minLength; i < maxP.length; i++) { 
            res[i] = maxP[i];
        }

        return new Polynomial(res);
        
    }

    //evaluate function
    public double evaluate(double val) { 
        double res = 0;
        double exp = 1;
        for(int i = 0; i < this.coeff.length; i++) { 
            res += exp*this.coeff[i];
            exp*=val;
        }
        return res;
    }

    public boolean hasRoot(double val) { 
        return this.evaluate(val) == 0;
    }
}
