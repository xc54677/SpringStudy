package springDemo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OilCarCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //如果当前环境是oil, 则加入oilCar
        Environment environment = conditionContext.getEnvironment();
        String carType = environment.getProperty("car.type");//car.type="oil"
        if (carType.contains("oil")){
            return true;
        }
        return false;
    }
}
