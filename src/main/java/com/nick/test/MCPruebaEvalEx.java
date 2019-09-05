package com.nick.test;

import com.udojava.evalex.AbstractFunction;
import com.udojava.evalex.Expression;
import com.udojava.evalex.Function;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class MCPruebaEvalEx {
    public static void main(String[] args) {
        String formulaPrecio = "precio_m2_escombros*MAXN(m2_escombros,1000)";
        String formulaPrecio2 = "termo_100l>0";
        BigDecimal resultado = BigDecimal.ZERO;

        Expression totalExpression = new Expression(formulaPrecio);
        Expression totalExpression2 = new Expression(formulaPrecio2);

        totalExpression.setVariable("precio_m2_escombros", new BigDecimal("120"));

        totalExpression.setVariable("m2_escombros", new BigDecimal(30));

        totalExpression2.setVariable("termo_100l", new BigDecimal("-10114"));

        totalExpression.addFunction(new AbstractFunction("MAXN", -1) {
            @Override
            public BigDecimal eval(List<BigDecimal> parameters) {
                if (parameters.size() == 0) {
                    throw new Expression.ExpressionException("average requires at least one parameter");
                }
                BigDecimal avg = new BigDecimal(0);
                for (BigDecimal parameter : parameters) {
                    avg = avg.add(parameter);
                }
                return avg.divide(new BigDecimal(parameters.size()));
            }
        });

        BigDecimal eval = totalExpression.eval().setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal eval2 = totalExpression2.eval().setScale(2, RoundingMode.HALF_EVEN);


        System.out.println(eval2);
    }
}
