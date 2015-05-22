package com.danielvalencia;

import java.time.LocalDateTime;

/**
 * @author Daniel Valencia (daniel@tacitknowledge.com)
 */
public class TodoItem
{
    private String description;
    private LocalDateTime completionDate;
    private Boolean completed;

    public TodoItem(String description, LocalDateTime completionDate, Boolean completed)
    {
        this.description = description;
        this.completionDate = completionDate;
        this.completed = completed;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
    }

    public Boolean getCompleted()
    {
        return completed;
    }

    public void setCompletionDate(final LocalDateTime completionDate)
    {
        this.completionDate = completionDate;
    }

    public LocalDateTime getCompletionDate()
    {
        return completionDate;
    }
}
