package edu.uade.gympal.shared.base.components;

import edu.uade.gympal.shared.base.messaging.MessageBus;
import edu.uade.gympal.shared.base.utils.EnumGymPal;

import java.util.ArrayList;
import java.util.List;

public class ComponentBase implements IComponent {
    EnumGymPal<Integer> id;
    List<IComponent> components = new ArrayList<>();
    MessageBus messageBus;

    public ComponentBase(EnumGymPal<Integer> id, MessageBus messageBus) {
        this.id = id;
        this.messageBus = messageBus;
    }

    @Override
    public EnumGymPal<Integer> getId() {
        return id;
    }

    @Override
    public void addComponent(IComponent component) {
        if (component != null) {
            IComponent existing = getComponent(component.getId());
            if (existing == null) {
                components.add(component);
            }
        }
    }

    @Override
    public IComponent getComponent(EnumGymPal<Integer> withId) {
        for (IComponent component: components) {
            if (component.getId() == withId) {
                return component;
            }
        }
        return null;
    }

    @Override
    public void run() {
        for (IComponent component: components) {
            component.run();
        }
    }

    public MessageBus getMessageBus() {
        return messageBus;
    }
}
