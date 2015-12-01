/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deploy;

import entity.Link;
import facades.LinkFacade;
import javax.persistence.Persistence;

/**
 *
 * @author Sindt
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkFacade facade = new LinkFacade();
        Link l = new Link();
        l.setUrl("http://angularairline-plaul.rhcloud.com/api/flightinfo/CPH/2016-01-04T23:00:00.000Z/3");
        l = facade.addLink(l);
        
        System.out.println(l.getLinkId());
        
        
    }

}
