package com.example.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;

public class X {
    public static void main(String[] args) {
        //допустим нам  в руки попался HttpServletRequest
        //и мы в фильтре будем отлавливать locale и устанавливать нужную
        HttpServletRequest request = null;

        //однако мы можем отлавливать запрос и ответ, но устанавливать в них мы мало что можем
        //для этого нам нужен класс обертка, который расширит наши возможности
        //мы можем переопределить обертку над httpservletrequest и добавить нужные методы работы с локалью (см. MyHttpServletRequestWrapper)
        HttpServletRequest request1 = new MyHttpServletRequestWrapper(request, Locale.FRANCE);

        //и дальше передаем этот request1, везде он ведет себя так же как обычный request,
        // только когда спрашиваешь у нее локаль - она возвращает локаль которую мы ей передали
        request1.getLocale();
    }
}

class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final Locale locale;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    MyHttpServletRequestWrapper(HttpServletRequest request, Locale locale) {
        super(request);
        this.locale = locale;
    }
//переписываем поведение методов родительского класса
    @Override
    public Locale getLocale() {
        return locale;
    }

    @Override
    public Enumeration<Locale> getLocales() {
        return Collections.enumeration(Collections.singletonList(locale));
    }

    //HttpServletRequestWrapper - он полностью повторяет методы HttpServletRequest никак его не расширяет,
    // это такая заготовка, нужна чтобы не реализовывать самому все методы интерфейса HttpServletRequest
}
