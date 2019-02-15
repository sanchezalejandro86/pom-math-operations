package ar.com.bancogalicia.po.bean;

import ar.com.bancogalicia.po.api.model.OperationResult;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Service;
import org.tempuri.Add;

import java.util.Arrays;
import java.util.List;

@Service("calculatorService")
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public List<Integer> generateAddRequest(Exchange exchange) {
        OperationResult result = exchange.getIn().getBody(OperationResult.class);

        exchange.setProperty("result", result);

        Add request = new Add();
        request.setIntA(result.getOperand1().intValue());
        request.setIntB(result.getOperand2().intValue());

        //return request;
        return Arrays.asList(result.getOperand1().intValue(), result.getOperand2().intValue());
    }
}
