import React, {Component} from "react";


class Sth extends Component{
    state = {
        games: []
    };

    async componentDidMount() {
        const response = await fetch('/games');
        const body = await response.json();
        this.setState({games: body});
    }

    render() {
        const {games} = this.state;
        return (
            <div>
                <header className="sht">
                    <h2>HOLA MUNDO</h2>
                    {games.map(Game =>
                        <div key={Game.id}>
                            gameID: {Game.id},  (pointsPlayer1: {Game.pointsPlayer1}, pointsPlayer2: {Game.pointsPlayer2})
                        </div>
                    )}
                </header>
            </div>
        );
    }
}
export default Sth;