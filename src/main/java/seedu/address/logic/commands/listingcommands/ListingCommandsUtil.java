package seedu.address.logic.commands.listingcommands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.listing.Address;
import seedu.address.model.listing.Area;
import seedu.address.model.listing.Listing;
import seedu.address.model.listing.Price;
import seedu.address.model.listing.Region;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Role;

import java.util.Set;

import static seedu.address.logic.commands.listingcommands.AddBuyersToListingCommand.MESSAGE_PERSON_NOT_BUYER;
import static seedu.address.logic.commands.listingcommands.AddListingCommand.MESSAGE_NOT_SELLER;

/**
 * Utility class containing helper methods for various Listing-related commands.
 */
public class ListingCommandsUtil {

    /**
     * Checks if the given person is a seller and throws a CommandException if so.
     *
     * @param person the person to check
     * @param role the role of the person
     * @param buyerIndex the index of the buyer in the list
     * @throws CommandException if the person is a seller
     */
    public static void checkIfBuyer(Person person, Role role, Index buyerIndex) throws CommandException {
        if (role.equals(Role.SELLER)) {
            throw new CommandException(String.format(MESSAGE_PERSON_NOT_BUYER,
                    buyerIndex.getOneBased(), person.getName()));
        }
    }

    /**
     * Checks if the given person is a buyer and throws a CommandException if so.
     *
     * @param person the person to check
     * @param role the role of the person
     * @param sellerIndex the index of the seller in the list
     * @throws CommandException if the person is a buyer
     */
    public static void checkIfSeller(Person person, Role role, Index sellerIndex) throws CommandException {
        if (role.equals(Role.BUYER)) {
            throw new CommandException(String.format(MESSAGE_NOT_SELLER,
                    sellerIndex.getOneBased(), person.getName()));
        }
    }

    /**
     * Updates the given listing with a new set of buyers.
     *
     * @param listingToEdit the listing to be updated
     * @param updatedBuyers the set of updated buyers
     * @return a new Listing object with the updated buyers
     */
    public static Listing updateListingWithBuyers(Listing listingToEdit, Set<Person> updatedBuyers) {
        Name name = listingToEdit.getName();
        Address address = listingToEdit.getAddress();
        Price price = listingToEdit.getPrice();
        Area area = listingToEdit.getArea();
        Region region = listingToEdit.getRegion();
        Person seller = listingToEdit.getSeller();

        return new Listing(name, address, price, area, region, seller, updatedBuyers);
    }
}
