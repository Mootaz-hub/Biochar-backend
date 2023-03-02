package tn.esprit.Interface;

import org.springframework.stereotype.Service;
import tn.esprit.Entity.Command;

import java.util.List;

@Service
public interface ICommandService {
    Command addCommand(Command command);
    Command modifyCommand(Command command);
    void deleteCommand(Long id);
    Command getCommandById(Long id);
    List<Command> getAllCommands();
    Command affectCommandToCommandLine(Command command, List<Long> idCommandLines);

    void disaffectCommandFromOrderLine(Long idCom, Long idComL);
    /*Command addCommandAndAffectProducts(Command command,List<Long> idPro);
    Command SetTotPriceCommand(Long id);*/


}
