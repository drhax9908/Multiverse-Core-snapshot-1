package com.onarandombox.MultiverseCore.commandTools.display.inline;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Show list separated by a comma.
 */
public class ShowList extends ShowInline<ListDisplay, List<String>> {

    public ShowList(@NotNull ListDisplay display) {
        super(display);
    }

    @Override
    protected void calculateContent() {
        boolean isFirst = true;
        for (String element : this.contents) {
            if (!this.display.getFilter().checkMatch(element)) {
                continue;
            }
            if (isFirst) {
                isFirst = false;
            }
            else {
                contentBuilder.append(", ");
            }
            contentBuilder.append(this.display.getColours().get())
                    .append(element);
        }
    }
}
