/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.orange.ease.dan.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orange.ease.dan.R;

public class MatchFieldView extends RelativeLayout {

    private LayoutInflater mLayoutInflater;
    private Drawable mHomeShirt;
    private Drawable mReceivedShirt;
    private int[] mRelativePositionX;
    private int[] mRelativePositionY;
    private String[] mPlayersRoles;
    private LineUp mLineUp;
    private String mTeamName1;
    private String mTeamName2;
    private Boolean mAccessible = true;

    public MatchFieldView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public MatchFieldView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MatchFieldView(final Context context) {
        super(context);
        init(context);
    }

    private void init(Context ctx) {
        mLayoutInflater = LayoutInflater.from(ctx);
        mRelativePositionX = ctx.getResources().getIntArray(R.array.player_x_relative_position);
        mRelativePositionY = ctx.getResources().getIntArray(R.array.player_y_relative_position);
        mPlayersRoles = ctx.getResources().getStringArray(R.array.player_role);
        mHomeShirt = ctx.getResources().getDrawable(R.drawable.maillot_noir);
        mReceivedShirt = ctx.getResources().getDrawable(R.drawable.maillot_gris);

        // Fake entry for our example
        String[] team1Nick = ctx.getResources().getStringArray(R.array.team1_players_nickname);
        String[] team2Nick = ctx.getResources().getStringArray(R.array.team2_players_nickname);
        int[] team1Role = ctx.getResources().getIntArray(R.array.team1_players_role);
        int[] team2Role = ctx.getResources().getIntArray(R.array.team2_players_role);

        setLineUp(team1Nick, team2Nick, team1Role, team2Role, ctx.getString(R.string.criteria_alt_ex3_team1), ctx.getString(R.string.criteria_alt_ex3_team2));

        updateAllPlayerView();
    }

    public void setLineUp(String[] team1Nick, String[] team2Nick, int[] team1Role, int[] team2Role, String team1Name, String team2Name) {

        mTeamName1 = team1Name;
        mTeamName2 = team2Name;

        mLineUp = new LineUp();

        if (team1Nick.length != team2Nick.length || team1Role.length != team2Role.length || team1Nick.length != team1Role.length) {
            mLineUp = null;
            return;
        }

        int length = team1Nick.length;
        mLineUp.team1 = new Player[length];
        mLineUp.team2 = new Player[length];
        for(int i = 0; i < length; i++){
            mLineUp.team1[i] =  new Player(team1Nick[i], team1Role[i]);
            mLineUp.team2[i] =  new Player(team2Nick[i], team2Role[i]);
        }
    }

    private void updateAllPlayerView() {
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {
                if (getViewTreeObserver().isAlive()) {
                    getViewTreeObserver().removeOnPreDrawListener(this);
                }
                if (getChildCount() == 0) {
                    if (hasPlayerWithPosition()) {
                        setupPlayers();
                    }
                    return true;
                }
                return false;
            }
        });
        postInvalidate();
    }

    private boolean hasPlayerWithPosition() {
        if (mLineUp != null) {
            final Player[] playersTeam1 = mLineUp.team1;
            final Player[] playersTeam2 = mLineUp.team2;
            if (playersTeam1 != null && playersTeam1.length != 0 && playersTeam2 != null
                    && playersTeam2.length != 0) {
                return true;
            }
        }
        return false;
    }

    private void setupPlayers() {
        addViewForPositionedPlayers(mLineUp.team1, true);
        addViewForPositionedPlayers(mLineUp.team2, false);
    }

    private void addViewForPositionedPlayers(final Player[] players, boolean isHomeTeam) {
        final int height = Math.max(getHeight(), getMeasuredHeight());
        final int width = Math.max(getWidth(), getMeasuredWidth());
        final String teamName = isHomeTeam ? mTeamName1 : mTeamName2;

        if (height > 0 && width > 0) {
            int size = players.length;

            for (final Player player : players) {
                int roleId = player.getRole();

                View playerView = mLayoutInflater
                        .inflate(R.layout.player_on_fields, this, false);

                TextView playerTv = (TextView) playerView.findViewById(R.id.player_name);
                Drawable shirtId = isHomeTeam ? mHomeShirt.mutate() : mReceivedShirt.mutate();
                playerTv.setCompoundDrawablesWithIntrinsicBounds(null, shirtId, null, null);

                playerTv.setText(player.getNickname());
                if (mAccessible) {
                    playerTv.setContentDescription(player.getNickname() + ", " + teamName + ", " + mPlayersRoles[roleId]);
                }

                if (roleId < mRelativePositionX.length) {
                    int relativeXpos;
                    int relativeYpos;

                    if (isHomeTeam) {
                        relativeXpos = 100 - mRelativePositionX[roleId];
                        relativeYpos = mRelativePositionY[roleId] / 2;
                    } else {
                        relativeXpos = mRelativePositionX[roleId];
                        relativeYpos = 100 - (mRelativePositionY[roleId] / 2);
                    }

                    final int xPos = (width * relativeXpos) / 100 - (
                            playerView.getLayoutParams().width
                                    / 2);
                    final int yPos = (height * relativeYpos) / 100 - shirtId
                            .getIntrinsicHeight();
                    setViewWithParameter(playerView, xPos, yPos);
                }
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (getChildCount() > 0) {
            removeAllViews();
            updateAllPlayerView();
        }
    }


    /**
     * @param currentPlayerView
     * @param xPos
     * @param yPos
     */
    private void setViewWithParameter(final View currentPlayerView,
                                      final int xPos, final int yPos) {
        LayoutParams params = new LayoutParams(currentPlayerView.getLayoutParams());
        params.setMargins(xPos, yPos, 0, 0);
        currentPlayerView.setLayoutParams(params);

        addView(currentPlayerView);
    }

    public void setAccessible(Boolean accessible) {
        this.mAccessible = accessible;
    }

    public class LineUp {
        public Player[] team1;
        public Player[] team2;
    }

    public class Player {
        private String mNickName;
        private int mRole;

        public String getNickname() {
            return mNickName;
        }
        public void setNickname(String firstName) {
            mNickName = firstName;
        }

        public int getRole() {
            return mRole;
        }
        public void setRole(int role) {
            mRole = role;
        }

        public Player(String nickName, int role) {
            this.mNickName = nickName;
            this.mRole = role;
        }
    }
}
