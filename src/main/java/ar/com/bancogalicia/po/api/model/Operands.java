package ar.com.bancogalicia.po.api.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Operands {
    private BigDecimal op1;

    private BigDecimal op2;

    public Operands op1(BigDecimal op1) {
        this.op1 = op1;
        return this;
    }

    public BigDecimal getOp1() {
        return op1;
    }

    public void setOp1(BigDecimal op1) {
        this.op1 = op1;
    }

    public Operands op2(BigDecimal op2) {
        this.op2 = op2;
        return this;
    }

    public BigDecimal getOp2() {
        return op2;
    }

    public void setOp2(BigDecimal op2) {
        this.op2 = op2;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operands operands = (Operands) o;
        return Objects.equals(this.op1, operands.op1) &&
                Objects.equals(this.op2, operands.op2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(op1, op2);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Operands {\n");

        sb.append("    op1: ").append(toIndentedString(op1)).append("\n");
        sb.append("    op2: ").append(toIndentedString(op2)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

