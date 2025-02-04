package tv.twitch.android.adapters.social;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class MessageRecyclerItem implements tv.twitch.android.core.adapters.RecyclerAdapterItem {
    public static class ChatMessageViewHolder extends ViewHolder {
        public ChatMessageViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public final TextView getMessageTextView() {
            throw new IllegalStateException("MessageRecyclerItem.ChatMessageViewHolder.getMessageTextView mock was called");
        }
    }
}
