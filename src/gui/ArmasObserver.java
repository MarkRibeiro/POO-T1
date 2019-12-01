package gui;

import java.awt.event.MouseEvent;

public interface ArmasObserver {
	void whenClicked (int posicao);
	void whenReleased (MouseEvent e, int posicao);
	void whenRightClicked(int butao, int posicao);
}
