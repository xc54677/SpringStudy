package springDemo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EnergyCarCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //如果当前环境是energy(能源), 则加入enegerCar
        Environment environment = conditionContext.getEnvironment();
        String carType = environment.getProperty("car.type");//car.type="energy"
        if (carType.contains("energy")){
            return true;
        }
        return false;
    }
}
