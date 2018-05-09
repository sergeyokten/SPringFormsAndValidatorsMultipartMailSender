package ua.com.owu.service.vaildators;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.owu.entity.User;

@Component
public class UserValidator implements Validator {
    // type safety
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;
        System.out.println(user);
        if (user.getAge() < 0) {
            errors.rejectValue("age", "kartoshka", "wrong age");
        }

    }
}
