package edu.uade.shared.base.components;

import edu.uade.shared.base.utils.EnumGymPal;

public interface IComponent {
    EnumGymPal<Integer> getId();

    void addComponent(IComponent component);
    IComponent getComponent(EnumGymPal<Integer> withId);

    void run();
}
