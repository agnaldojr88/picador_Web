# Picador - Web

---------------

**Desenvolvedor:** Agnaldo Alves da Silva Junior

**E-mail:** agnaldo@rosseti.ind.br ou agnaldo88@gmail.com

**Módulo:** Alocado no servidor da Rosseti, para coleta, tratamento e visualização das informações (API).

**Java 17**

-----------------------

Comando para inicializar no servidor Linux VW-Web:
```code
sudo systemctl start java-web.service
```
Para verificar o status:
```code
journalctl -u java-web.service -f
```
Ou
```code
sudo systemctl status java-web.service
```

Observação:
Serviço configurado para inicializar automaticamente com a VM Web no servidor Rosseti.

-----------------------

### Rosseti Electric

