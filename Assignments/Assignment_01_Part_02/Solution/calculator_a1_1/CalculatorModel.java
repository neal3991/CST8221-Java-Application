/************************************************************************************************************************************
* Filename:                     CalculatorModel.java                                                                                 *
* Version:                      2.0                                                                                                 *
* Author:                       Niladri Sengupta                                                                                    *
* Student No:                   040777969                                                                                           *
* Course Name/Number:           CST 8221 (Java Applications)                                                                        *
* Lab Sect:                     310                                                                                                 *
* Assignment #:                 01-Part_02                                                                                          *
* Assignment name:              Calculator                                                                                          *
* Due Date:                     March 11, 2017                                                                                   *
* Submission Date:              March 11, 2017                                                                                   *
* Professor:                    Svillen Ranev                                                                                       *
* Purpose:                      Set up an environment that displays the interface of a calculator (to be further used)              *
* Note:                         This program was made in NetBeans_IDE_8.2. For optimal performance run in in NetBeans_IDE_8.2       *
*************************************************************************************************************************************/
package calculator_a1_1;

/********************************************************************************
* @Purpose:             To handle all aspects of calculations and errors        *
* @Author:              Niladri Sengupta                                        *
* @Version:             1.0                                                     *
* @See:                 calculator_a1_1, CalculatorView (Outer Class)           *
* @Since:               8.2                                                     *
*********************************************************************************/


public class CalculatorModel {
    /* Which operand is in use */
    private Oper oper;
    /* Which mode is in use */
    private OpMode opMode;
    /* Which precision is in use */
    private Prec prec;    
    /* Error output */
    private static final String ERROR_STRING = "--";
    /* Num1 and Num2 for input and calculations */
    private double num1, num2;
    /* Final result */
    private double result;
    /* If error or not */
    private boolean error_status;

    /********************************************************************
    * @Purpose:            Default constructor for this class           *
    * @Param:              N/A                                          *
    * @Return:             N/A                                          *
    ********************************************************************/   
    public CalculatorModel() {
        opMode = OpMode.Float;
        prec = Prec.Double;
        delete();
    }
    /* Enums to be used further in methods */
    public enum OpMode {
        Integer, Float
    }
    /* Enums to be used further in methods */
    public enum Oper {
        Addition, Subtraction, Multiplication, Division
    }
    /* Enums to be used further in methods */
    public enum Prec {
        Single, Double, Scientific
    }    
    /* Setter*/
    public void setNum1(double operand) {
        num1 = operand;
    }
    /* Getter */
    public double getNum1() {
        return num1;
    }
    /* Getter */
    public void getNum2(double operand) {
        num2 = operand;
    }
    /* Getter */
    public double getNum2() {
        return num2;
    }
    /* Setter */    
    public void errorMode(boolean error_status) {
        this.error_status = error_status;
    }	
    /* Getter */
    public boolean getError() {
        return error_status;
    }
    /* Setter*/
    public void setOper(Oper oper) {
        if(oper == null)
            //throws exception
            throw new NullPointerException();			

        this.oper = oper;
    }
    /* Getter */
    public Oper getOper() {
        return oper;
    }
    /* Setter*/
    public void setPrec (Prec prec) {
        if (prec == null){
            throw new NullPointerException();
        }
        this.prec = prec;
    }
    /* Getter */
    public Prec getPrec() {
        return prec;
    }
    /* Setter*/
    public void setOperMode(OpMode opMode) {
        if(opMode== null){
            throw new NullPointerException();        
        }         
        this.opMode = opMode;
        /* Updating the Num1 and Num2 */
        if(opMode == OpMode.Integer) {
            num1 = (int)num1;
            num2 = (int)num2;
            result = (int)result;
        }
    }
    /* Getter */
    public OpMode getOperMode() {
        return opMode;
    }
    /* Resetting values and nums */
    public void delete(){
        if(opMode == OpMode.Float) {
            num1 = num2 = result = 0.0d;
        }
        else {
            num1 = num2 = result = 0;
        }
        errorMode(false);
    }
    /* If result is valid or not */
    private boolean isValid() {
        return !Double.isNaN(result) && !Double.isInfinite(result);
    }
    /* Setter */
    public void setNum1Total() {
        double total = this.result;
        delete();
        num1 = total;
    }
    /********************************************************************
    * @Purpose:            Getting the operationMode and precision      *
    * @Param:              N/A                                          *
    * @Return:             String                                       *
    ********************************************************************/
    public String getResult() {
        if (error_status){
            return ERROR_STRING;        
        }
        /* Switch based on Operation mode */
        switch (opMode) {
        /* Mode Int */
        case Integer:
            return String.format("%d", (int)result);
        /* Mode F */
        case Float:
            if (result == 0.0d) {
                return String.format("%.1f", result);
            }
            /* Switch based on precision */
            switch (prec) {
                /* Precision .0 */
                case Single:
                    return String.format("%.1f", result);
                /* Precision .00 */
                case Double:
                    return String.format("%.2f", result);
                /* Precision Sci */
                case Scientific:
                    return String.format("%.6e", result).replace("e", "E");
            }
        default:
            return ERROR_STRING;
        }
    }
    /********************************************************************
    * @Purpose:            Perform calculations based on operation      *
    * @Param:              N/A                                          *
    * @Return:             N/A                                          *
    ********************************************************************/
    public void performCalculations() {
        try {
            /* Switch based on operation  */
            switch(oper) {
            /* Addition */
            case Addition:
                if (num2 != 0) {
                     result = num1 + num2;
                 } 
                else {
                     result = num1 + num2;
                 };
                 break;
            /* Substraction */
            case Subtraction:
                if (num1 != 0 && num2 != 0) {
                    result = num1 - num2;
                } 
                else {
                    result = num1 - num2;
                };
                break;
            /* Division */
            case Division:
                if (num2 == 0) {
                    error_status = true;
                } 
                else if (num2 == 0 && num1 > 1) {
                    result = num1 / num1;
                } 
                else if ((num1 > 0 || num1 < 0) && num2 > 0) {
                    result = num1 / num2;
                };
                break;
            /* Multiplication */
            case Multiplication:
                if (num2 == 0) {
                    result = num1 * num2;
                } 
                else {
                    result = num1 * num2;
                }
                num1 = 0;
                num2 = 0;
                break;
            default:
                return;
            }          
        }
        /* Checking for error */
        catch (Exception e) {
            error_status = true;
            result = 0.0d;
            return;
        }

        if (!isValid()) {
            error_status = true;
            result = 0.0d;
        }

    }    
}