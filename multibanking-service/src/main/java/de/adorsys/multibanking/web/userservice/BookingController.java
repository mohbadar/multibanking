package de.adorsys.multibanking.web.userservice;

import de.adorsys.multibanking.domain.Booking;
import de.adorsys.multibanking.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alexg on 07.02.17.
 */
@RestController
@RequestMapping(path = "api/v1/users/{userId}/bankaccesses/{accessId}/accounts/{accountId}/bookings")
public class BookingController {

    private static final Logger log = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Resources<List<Booking>> getBankAccounts(@PathVariable("userId") String userId, @PathVariable(value = "accessId") String accessId, @PathVariable(value = "accountId") String accountId) {
        List<Booking> bookings = bookingRepository.findByAccountId(accountId).get();
        return new Resources(bookings);
    }

}
