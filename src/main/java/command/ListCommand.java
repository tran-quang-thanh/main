package command;

import Dictionary.WordBank;
import exception.WordBankEmptyException;
import storage.Storage;
import ui.Ui;

/**
 * Represents a command from user to lists current tasks.
 * Inherits from Command class.
 */
public class ListCommand extends Command {

    String order;

    public ListCommand(String order) {
        this.order = order;
    }

    @Override
    public void execute(Ui ui, WordBank wordBank, Storage storage) {
        //ask ui to print something
        //ask tasks to store the thing in arraylist
        //ask storage to write to file
        try {
            if (wordBank.getWordBank().isEmpty()) {
                throw new WordBankEmptyException();
            }
            ui.showList(wordBank, this.order);
        } catch (WordBankEmptyException e) {
            e.showError();
        }
    }
}
