package ar.com.bancogalicia.po.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class OperationResult {

    @JsonProperty("operation_id")
    private Integer operationId;

    @JsonProperty("operand1")
    private BigDecimal operand1;

    @JsonProperty("operand2")
    private BigDecimal operand2;

    /**
     * Gets or Sets operator
     */
    public enum OperatorEnum {
        ADD("ADD"),

        SUB("SUB"),

        MUL("MUL"),

        DIV("DIV");

        private String value;

        OperatorEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static OperatorEnum fromValue(String text) {
            for (OperatorEnum b : OperatorEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + text + "'");
        }
    }

    @JsonProperty("operator")
    private OperatorEnum operator;

    @JsonProperty("result")
    private BigDecimal result;

    public OperationResult operationId(Integer operationId) {
        this.operationId = operationId;
        return this;
    }

    /**
     * Get operationId
     * @return operationId
     **/
    @ApiModelProperty(required = true, value = "")
    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public OperationResult operand1(BigDecimal operand1) {
        this.operand1 = operand1;
        return this;
    }

    /**
     * Get operand1
     * @return operand1
     **/
    @ApiModelProperty(required = true, value = "")
    public BigDecimal getOperand1() {
        return operand1;
    }

    public void setOperand1(BigDecimal operand1) {
        this.operand1 = operand1;
    }

    public OperationResult operand2(BigDecimal operand2) {
        this.operand2 = operand2;
        return this;
    }

    /**
     * Get operand2
     * @return operand2
     **/
    @ApiModelProperty(required = true, value = "")
    public BigDecimal getOperand2() {
        return operand2;
    }

    public void setOperand2(BigDecimal operand2) {
        this.operand2 = operand2;
    }

    public OperationResult operator(OperatorEnum operator) {
        this.operator = operator;
        return this;
    }

    /**
     * Get operator
     * @return operator
     **/
    @ApiModelProperty(required = true, value = "")
    public OperatorEnum getOperator() {
        return operator;
    }

    public void setOperator(OperatorEnum operator) {
        this.operator = operator;
    }

    public OperationResult result(BigDecimal result) {
        this.result = result;
        return this;
    }

    /**
     * Get result
     * @return result
     **/
    @ApiModelProperty(required = true, value = "")
    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OperationResult operationResult = (OperationResult) o;
        return Objects.equals(this.operationId, operationResult.operationId) &&
                Objects.equals(this.operand1, operationResult.operand1) &&
                Objects.equals(this.operand2, operationResult.operand2) &&
                Objects.equals(this.operator, operationResult.operator) &&
                Objects.equals(this.result, operationResult.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, operand1, operand2, operator, result);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OperationResult {\n");

        sb.append("    operationId: ").append(toIndentedString(operationId)).append("\n");
        sb.append("    operand1: ").append(toIndentedString(operand1)).append("\n");
        sb.append("    operand2: ").append(toIndentedString(operand2)).append("\n");
        sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

