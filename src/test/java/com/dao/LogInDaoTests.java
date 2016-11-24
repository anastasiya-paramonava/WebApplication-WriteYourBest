package com.dao;

import com.dao.exceptions.DaoException;
import com.model.users.UnauthorizedUser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Anastasia_Paramonova on 23.11.2016.
 */
public class LogInDaoTests {

    @Test
    public void authorize_WhenUserExists_ShouldReturnUnauthorizedUserObject() throws DaoException {
        //arrange
        LogInDao underTest = new LogInDao();
        String valueToTest = "Anastasia";

        //act
        UnauthorizedUser actual = underTest.findUser(valueToTest);

        //assert
        UnauthorizedUser expected = new UnauthorizedUser(1, "Anastasia", "123456");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void authorize_WhenUserNotExists_ShouldReturnNull() throws DaoException {
        //arrange
        LogInDao underTest = new LogInDao();
        String valueToTest = "Avtandil";

        //act
        UnauthorizedUser actual = underTest.findUser(valueToTest);

        //assert
        UnauthorizedUser expected = null;
        Assert.assertEquals(expected, actual);

    }

    @Test(expected = DaoException.class)
    public void authorize_WhenInputDataIncorrect_ShouldThrowException() throws DaoException {
        //arrange
        LogInDao underTest = new LogInDao();
        String valueToTest =  null;

        //act
        UnauthorizedUser actual = underTest.findUser(valueToTest);
    }

}